package com.job;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.job.entity.Jobs;
import com.job.repository.JobRepository;
import com.job.service.JobService;

@SpringBootTest
class JobApplicationTests {
	
	
	@Mock
	private JobRepository jobRepository;
	
	@InjectMocks
	private JobService jobService;

	@Test
    public void testGetAllJobs() {
        Jobs job1 = new Jobs(1L, "Software Engineer", "Description 1", "10000", "5000", "Location 1");
        Jobs job2 = new Jobs(2L, "Data Analyst", "Description 2", "9000", "4000", "Location 2");
        List<Jobs> jobs = Arrays.asList(job1, job2);

        when(jobRepository.findAll()).thenReturn(jobs);
        when(jobRepository.findAll()).thenReturn(jobs);

        List<Jobs> result = jobService.getJobs();

        assertEquals(2, result.size());
        assertNotEquals(1, result.size());
    }
	

}
