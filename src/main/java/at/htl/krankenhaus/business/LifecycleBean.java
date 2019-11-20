package at.htl.krankenhaus.business;

import at.htl.krankenhaus.model.*;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;

// The Quarkus way
@ApplicationScoped
@Transactional
public class LifecycleBean {
    private static final Logger LOGGER = LoggerFactory.getLogger("LifecycleBean");

    // TODO: Why not @Inject?
    @PersistenceContext
    EntityManager em;

    void onStart(@Observes StartupEvent ev) {
        LOGGER.info("Startup");
        Doctor doctorStrange = new Doctor("Doctor Strange", 0);
        Doctor doctorWho = new Doctor("Doctor Strange", 666);

        Patient patientChell = new Patient("Test Subject", LocalDate.now());
        Patient patientAdam = new Patient("Adam Doe", LocalDate.of(1999, 9, 9));
        Patient patientEve = new Patient("Eve Eveman", LocalDate.of(2001, 3, 2));

        Treatment uselessTreatment = new GeneralTreatment(
                "Homeopathy",
                doctorWho,
                patientAdam,
                "no outcome",
                LocalDate.now(),
                LocalDate.now().plusDays(45),
                "A treatment with a very tenuous effect.");

        Treatment drugTreatment = new DrugTreatment(
                "Magic Shrooms",
                doctorStrange,
                patientEve,
                "no outcome",
                LocalDate.now().minusDays(34),
                LocalDate.now().plusDays(5),
                "Magic Shrooms",
                3
        );

        doctorStrange.persist();
        doctorWho.persist();
        patientChell.persist();
        patientAdam.persist();
        patientEve.persist();

        uselessTreatment.persist();
        drugTreatment.persist();
    }

    void onStop(@Observes ShutdownEvent ev) {
        LOGGER.info("Shutdown");
    }
}
