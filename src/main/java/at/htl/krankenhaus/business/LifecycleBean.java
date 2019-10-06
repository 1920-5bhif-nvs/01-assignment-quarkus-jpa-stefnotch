package at.htl.krankenhaus.business;

import at.htl.krankenhaus.model.Doctor;
import at.htl.krankenhaus.model.DrugTreatment;
import at.htl.krankenhaus.model.Patient;
import at.htl.krankenhaus.model.Treatment;
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
        Doctor doc =
                new Doctor("testDoctor", 0);
        Patient patient =
                new Patient("testSubject", LocalDate.now());
        DrugTreatment dt = new DrugTreatment(
                "test",
                doc,
                patient,
                "no outcome",
                LocalDate.of(1999, 9, 9),
                LocalDate.of(1999, 9, 19),
                "testDrug",
                3
        );
        em.persist(doc);
        em.persist(patient);
        em.persist(dt);
    }

    void onStop(@Observes ShutdownEvent ev) {
        LOGGER.info("Shutdown");
    }
}
