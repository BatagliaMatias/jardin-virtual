package jardin.virtual

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VinculoTemporalServiceSpec extends Specification {

    VinculoTemporalService vinculoTemporalService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new VinculoTemporal(...).save(flush: true, failOnError: true)
        //new VinculoTemporal(...).save(flush: true, failOnError: true)
        //VinculoTemporal vinculoTemporal = new VinculoTemporal(...).save(flush: true, failOnError: true)
        //new VinculoTemporal(...).save(flush: true, failOnError: true)
        //new VinculoTemporal(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //vinculoTemporal.id
    }

    void "test get"() {
        setupData()

        expect:
        vinculoTemporalService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<VinculoTemporal> vinculoTemporalList = vinculoTemporalService.list(max: 2, offset: 2)

        then:
        vinculoTemporalList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        vinculoTemporalService.count() == 5
    }

    void "test delete"() {
        Long vinculoTemporalId = setupData()

        expect:
        vinculoTemporalService.count() == 5

        when:
        vinculoTemporalService.delete(vinculoTemporalId)
        sessionFactory.currentSession.flush()

        then:
        vinculoTemporalService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        VinculoTemporal vinculoTemporal = new VinculoTemporal()
        vinculoTemporalService.save(vinculoTemporal)

        then:
        vinculoTemporal.id != null
    }
}
