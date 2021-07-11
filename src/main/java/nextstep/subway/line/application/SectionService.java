package nextstep.subway.line.application;

import nextstep.subway.line.domain.SectionRepository;
import nextstep.subway.line.domain.Sections;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SectionService {

    private final SectionRepository sectionRepository;

    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @Transactional(readOnly = true)
    public Sections findSections() {
        return new Sections(sectionRepository.findAll());
    }
}
