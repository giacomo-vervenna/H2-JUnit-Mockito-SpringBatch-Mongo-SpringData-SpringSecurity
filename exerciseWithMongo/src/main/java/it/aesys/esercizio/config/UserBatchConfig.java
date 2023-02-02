package it.aesys.esercizio.config;

import it.aesys.esercizio.dto.RawUser;
import it.aesys.esercizio.entities.User;
import it.aesys.esercizio.items.UserProcessor;
import it.aesys.esercizio.repositories.UserRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Configuration
@EnableBatchProcessing
public class UserBatchConfig {

    @Autowired
    JobBuilderFactory jobBuilder;

    @Autowired
    StepBuilderFactory stepBuilder;

    @Autowired
    UserProcessor userProcessor;

    @Autowired
    MongoTemplate template;

    @Autowired
    UserRepository repo;

    @Bean
    public FlatFileItemReader<RawUser> reader() {
        FlatFileItemReader<RawUser> reader = new FlatFileItemReader<RawUser>();
        reader.setResource(new ClassPathResource("person.csv"));
        reader.setLineMapper(new DefaultLineMapper<>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[]{"fiscalCode", "name", "surname","street", "civic", "postalCode", "birthDate"});
            }});

            setFieldSetMapper(new BeanWrapperFieldSetMapper<RawUser>() {{
                setTargetType(RawUser.class);
            }});
        }});

        return reader;
    }

    @Bean
    public RepositoryItemWriter<User> writer() {
        RepositoryItemWriter<User> writer = new RepositoryItemWriter<User>();
        writer.setRepository(repo);
        writer.setMethodName("save");
        return writer;
    }

    @Bean
    public Step step1() {
        return stepBuilder.get("step1")
                .<RawUser,User>chunk(10)
                .reader(reader())
                .processor(userProcessor)
                .writer(writer())
                .build();
    }
    @Bean
    public Job job() {
        return jobBuilder.get("job")
                .start(step1())
                .build();
    }
}

