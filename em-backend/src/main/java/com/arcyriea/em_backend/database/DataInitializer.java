package com.arcyriea.em_backend.database;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final String INITIALIZATION_LOCK = "application-initialized.lock";
    private final JdbcTemplate jdbcTemplate;
    private final ResourceLoader resourceLoader;

    @Override
    public void run(String... args) throws Exception {
        File initialized = new File(INITIALIZATION_LOCK);

        if (!initialized.exists()){
            Resource dataScript = resourceLoader.getResource("classpath:db/data.sql");
            try (Reader reader = new InputStreamReader(dataScript.getInputStream(), StandardCharsets.UTF_8)) {
                String content = FileCopyUtils.copyToString(reader);
                List<String> sqlStatements = Arrays.stream(content.split(";")).map(String::trim).filter(s -> !s.isEmpty()).collect(Collectors.toList());

                System.out.println("Executing SQL statements from file:");
                for (String sql : sqlStatements) {
                    System.out.println("Executing: " + sql);
                    jdbcTemplate.execute(sql);
                }
                System.out.println("SQL statements executed successfully.");
                initialized.createNewFile();
            } catch (IOException e) {
                System.err.println("Error loading data.sql: " + e.getMessage());
            }
        } else {
            System.out.println("Data was already initialized");
        }
        
    }
    
}
