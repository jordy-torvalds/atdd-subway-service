package nextstep.subway.path.ui;

import nextstep.subway.path.application.PathService;
import nextstep.subway.path.dto.PathResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paths")
public class PathController {

    private final PathService pathService;

    public PathController(PathService pathService) {
        this.pathService = pathService;
    }

    @GetMapping
    public ResponseEntity findShortestPath(@RequestParam(name = "source") Long source, @RequestParam(name = "target") Long target) {
        PathResponse pathResponse = pathService.findShortestPath(source, target);

        return ResponseEntity.ok().body(pathResponse);
    }

    @ExceptionHandler({
            NoStationInListException.class, SameSourceTargetException.class, SourceTargetNotConnectException.class
    })
    public ResponseEntity exceptionHandler() {
        return ResponseEntity.badRequest().build();
    }

}
