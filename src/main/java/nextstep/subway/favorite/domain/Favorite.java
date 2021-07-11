package nextstep.subway.favorite.domain;

import nextstep.subway.BaseEntity;
import nextstep.subway.station.domain.Station;

import javax.persistence.*;

@Entity
public class Favorite extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_station_id")
    private Station source;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_station_id")
    private Station target;

    protected Favorite() {

    }

    public Favorite(Long id, Long memberId, Station source, Station target) {
        this.id = id;
        this.memberId = memberId;
        this.source = source;
        this.target = target;
    }

    public Favorite(Long memberId, Station source, Station target) {
        this.memberId = memberId;
        this.source = source;
        this.target = target;
    }

    public Long getId() {
        return id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public Station getSource() {
        return source;
    }

    public Station getTarget() {
        return target;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", source=" + source +
                ", target=" + target +
                '}';
    }
}
