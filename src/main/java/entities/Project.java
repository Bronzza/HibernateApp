package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import java.util.Set;

@Log4j
@javax.persistence.Entity(name = "projects")

@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Project extends Task {
    @Column(name = "date_of_start")
    private String date;
    @Column(name = "cost")
    private Integer cost;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "projectsSet")
    private Set<Developer> developers;

    @Override
    public String toString() {
        return "Project{" +
                "id=" + getId() +
                ", name='" + getName() +
                ", date='" + date +
                ", cost=" + cost +
                '}';
    }

    @PostLoad
    private void writeLog() {
        log.info("Loading is finished");
    }
}