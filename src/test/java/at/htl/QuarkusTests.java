package at.htl;

import at.htl.krankenhaus.model.Doctor;
import at.htl.krankenhaus.model.GeneralTreatment;
import at.htl.krankenhaus.model.Patient;
import at.htl.krankenhaus.model.Treatment;
import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;

@QuarkusTest
public class QuarkusTests {

    @Test
    public void testDirtyTracking() {
        // Test to makes sure that Quarkus applies
        // http://isd-soft.com/tech_blog/hibernate-bytecode-enhancement-dirty-tracking/

        Doctor doc = new Doctor("testDoctor", 0);
        Patient patient = new Patient("testSubject", LocalDate.now());

        assertThat(doc.name).isEqualTo("testDoctor");
        assertThat(doc.treatments).isEmpty();

        Treatment testTreatment = new GeneralTreatment(
                "Homeopathy",
                doc,
                patient,
                "no outcome",
                LocalDate.of(1999, 9, 9),
                LocalDate.of(1999, 9, 19),
                "Super effective :tm:");

        assertThat(doc.treatments).isNotEmpty();
        assertThat(doc.treatments.size()).isEqualTo(1);
        assertThat(doc.treatments).containsExactlyInAnyOrder(testTreatment);
        assertThat(testTreatment.doctor).isEqualTo(doc);
    }
}
