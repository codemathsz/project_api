package br.com.codemathsz.stage.exceptions;

public class ProjectNotFoundException extends RuntimeException {

    public ProjectNotFoundException() {
        super("Project not found.");
    }
}
