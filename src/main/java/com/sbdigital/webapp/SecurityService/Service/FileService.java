package com.sbdigital.webapp.SecurityService.Service;

import com.sbdigital.webapp.SecurityService.Domain.File;
import com.sbdigital.webapp.SecurityService.Domain.Proposal;
import com.sbdigital.webapp.SecurityService.Repository.FileRepository;
import com.sbdigital.webapp.SecurityService.Repository.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private ProposalRepository proposalRepository;

    public File saveFile(MultipartFile multipartFile, Long taskId, Long userId) throws IOException {
        String fileName = userId + "_" + taskId + "_" + multipartFile.getOriginalFilename();
        Path directory = Paths.get("uploads");
        if (!Files.exists(directory)) {
            Files.createDirectories(directory);
        }
        Path path = directory.resolve(fileName);
        Files.copy(multipartFile.getInputStream(), path);

        File file = new File();
        file.setTaskId(taskId);
        file.setUserId(userId);
        file.setFileName(fileName);
        Optional<Proposal> optionalProposal = proposalRepository.findById(taskId);
        if (optionalProposal.isPresent()) {
            Proposal proposal = optionalProposal.get();
            if (!proposal.getContributors().contains(userId)) {
                proposal.getContributors().add(userId);
                proposalRepository.save(proposal);
            }
        }
        return fileRepository.save(file);
    }

    public File getFileByTaskIdAndUserId(Long taskId, Long userId) {
        return fileRepository.findByTaskIdAndUserId(taskId, userId);
    }
}