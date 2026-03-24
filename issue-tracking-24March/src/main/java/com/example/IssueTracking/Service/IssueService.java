package com.example.IssueTracking.Service;

import com.example.IssueTracking.Entity.Issue;
import com.example.IssueTracking.Entity.IssueStatus;
import com.example.IssueTracking.Repository.IssueRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class IssueService {

    @Autowired
    private final IssueRepository issueRepository;

    public List<Issue> getUnresolvedIssues(Long employeeId) {
        log.info("Request received: Fetch unresolved issues for employeeId={}", employeeId);
        return issueRepository.findByEmployeeIdAndStatusNot(employeeId, IssueStatus.RESOLVED);
    }


    public List<Issue> getIssuesThisMonth() {
        LocalDate start = LocalDate.now().withDayOfMonth(1);
        LocalDate end = LocalDate.now();
        log.info("Request received: Fetch issues from {} to {}", start, end);
        return issueRepository.findByCreatedDateBetween(start, end);
    }

    public List<String> getEmployeeNamesThisMonth() {
        LocalDate start = LocalDate.now().withDayOfMonth(1);
        LocalDate end = LocalDate.now();
        log.info("Request received: Fetch employee names for this month");
        return issueRepository.findByCreatedDateBetween(start, end)
                .stream()
                .map(issue -> issue.getEmployee().getName())
                .distinct()
                .collect(Collectors.toList());
    }
}