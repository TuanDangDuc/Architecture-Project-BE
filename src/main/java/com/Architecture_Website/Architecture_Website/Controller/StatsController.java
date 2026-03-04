package com.Architecture_Website.Architecture_Website.Controller;

import com.Architecture_Website.Architecture_Website.Repository.PostRepository;
import com.Architecture_Website.Architecture_Website.Repository.ProjectRepository;
import com.Architecture_Website.Architecture_Website.Repository.TicketRepository;
import com.Architecture_Website.Architecture_Website.Repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/stats")
@RequiredArgsConstructor
public class StatsController {

    private final ProjectRepository projectRepository;
    private final PostRepository postRepository;
    private final VideoRepository videoRepository;
    private final TicketRepository ticketRepository;

    @GetMapping
    public ResponseEntity<Map<String, Long>> getStats() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("totalProjects", projectRepository.count());
        stats.put("totalPosts", postRepository.count());
        stats.put("totalVideos", videoRepository.count());
        stats.put("totalConsultations", ticketRepository.count());
        return ResponseEntity.ok(stats);
    }
}
