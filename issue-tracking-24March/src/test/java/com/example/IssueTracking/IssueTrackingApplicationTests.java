package com.example.IssueTracking;

import com.example.IssueTracking.Entity.Issue;
import com.example.IssueTracking.Repository.IssueRepository;
import com.example.IssueTracking.Service.IssueService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IssueTrackingApplicationTests {

    @Autowired
    private IssueService issueService;

    @Autowired
    private IssueRepository issueRepository;

    @Test
    void testGetUnresolvedIssues() {

        List<Issue> issues = issueService.getUnresolvedIssues(1L);

        System.out.println("Unresolved Issues: " + issues);

        assertNotNull(issues);
    }

    @Test
    void testGetIssuesThisMonth() {

        List<Issue> issues = issueService.getIssuesThisMonth();

        System.out.println("Issues This Month: " + issues);

        assertNotNull(issues);
    }

    @Test
    void testGetEmployeeNamesThisMonth() {

        List<String> names = issueService.getEmployeeNamesThisMonth();

        System.out.println("Employee Names: " + names);

        assertNotNull(names);
        assertTrue(names.size() > 0); // should have data from DataLoader
    }
}