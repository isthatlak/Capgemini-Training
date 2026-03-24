package com.example.IssueTracking.Controller;

import com.example.IssueTracking.Entity.Issue;
import com.example.IssueTracking.Service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/issues")
@RequiredArgsConstructor
public class IssueController {

    private final IssueService issueService;

    @GetMapping("/employee/{id}/unresolved")
    public List<Issue> getUnresolvedIssues(@PathVariable Long id) {
        return issueService.getUnresolvedIssues(id);
    }

    @GetMapping("/this-month")
    public List<Issue> getIssuesThisMonth() {
        return issueService.getIssuesThisMonth();
    }

    @GetMapping("/employees/this-month")
    public List<String> getEmployeeNamesThisMonth() {
        return issueService.getEmployeeNamesThisMonth();
    }
}