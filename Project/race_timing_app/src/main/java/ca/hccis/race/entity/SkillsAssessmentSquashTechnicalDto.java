package ca.hccis.race.entity;

import ca.hccis.race.jpa.entity.SkillsAssessmentSquashTechnical;

import java.util.ArrayList;
import java.util.List;

public class SkillsAssessmentSquashTechnicalDto {
    private List<SkillsAssessmentSquashTechnical> assessments;

    // default and parameterized constructor


    public SkillsAssessmentSquashTechnicalDto() {
        assessments = new ArrayList<SkillsAssessmentSquashTechnical>();
    }

    public SkillsAssessmentSquashTechnicalDto(List<SkillsAssessmentSquashTechnical> assessments) {
        this.assessments = assessments;
    }

    public void addSkillsAssessmentSquashTechnical(SkillsAssessmentSquashTechnical skillsAssessmentSquashTechnical) {
        this.assessments.add(skillsAssessmentSquashTechnical);
    }

    public List<SkillsAssessmentSquashTechnical> getAssessments() {
        return assessments;
    }

    public void setAssessments(List<SkillsAssessmentSquashTechnical> assessments) {
        this.assessments = assessments;
    }
}
