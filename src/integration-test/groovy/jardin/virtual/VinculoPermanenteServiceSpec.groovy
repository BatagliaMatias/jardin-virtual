package jardin.virtual

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VinculoPermanenteServiceSpec extends Specification {

    VinculoPermanenteService vinculoPermanenteService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new VinculoPermanente(...).save(flush: true, failOnError: true)
        //new VinculoPermanente(...).save(flush: true, failOnError: true)
        //VinculoPermanente vinculoPermanente = new VinculoPermanente(...).save(flush: true, failOnError: true)
        //new VinculoPermanente(...).save(flush: true, failOnError: true)
        //new VinculoPermanente(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //vinculoPermanente.id
    }

    void "test get"() {
        setupData()

        expect:
        vinculoPermanenteService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<VinculoPermanente> vinculoPermanenteList = vinculoPermanenteService.list(max: 2, offset: 2)

        then:
        vinculoPermanenteList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        vinculoPermanenteService.count() == 5
    }

    void "test delete"() {
        Long vinculoPermanenteId = setupData()

        expect:
        vinculoPermanenteService.count() == 5

        when:
        vinculoPermanenteService.delete(vinculoPermanenteId)
        sessionFactory.currentSession.flush()

        then:
        vinculoPermanenteService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        VinculoPermanente vinculoPermanente = new VinculoPermanente()
        vinculoPermanenteService.save(vinculoPermanente)

        then:
        vinculoPermanente.id != null
    }
}
