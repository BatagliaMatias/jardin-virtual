package jardin.virtual

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SolicitudVinculoFamiliarServiceSpec extends Specification {

    SolicitudVinculoFamiliarService solicitudVinculoFamiliarService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SolicitudVinculoFamiliar(...).save(flush: true, failOnError: true)
        //new SolicitudVinculoFamiliar(...).save(flush: true, failOnError: true)
        //SolicitudVinculoFamiliar solicitudVinculoFamiliar = new SolicitudVinculoFamiliar(...).save(flush: true, failOnError: true)
        //new SolicitudVinculoFamiliar(...).save(flush: true, failOnError: true)
        //new SolicitudVinculoFamiliar(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //solicitudVinculoFamiliar.id
    }

    void "test get"() {
        setupData()

        expect:
        solicitudVinculoFamiliarService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SolicitudVinculoFamiliar> solicitudVinculoFamiliarList = solicitudVinculoFamiliarService.list(max: 2, offset: 2)

        then:
        solicitudVinculoFamiliarList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        solicitudVinculoFamiliarService.count() == 5
    }

    void "test delete"() {
        Long solicitudVinculoFamiliarId = setupData()

        expect:
        solicitudVinculoFamiliarService.count() == 5

        when:
        solicitudVinculoFamiliarService.delete(solicitudVinculoFamiliarId)
        sessionFactory.currentSession.flush()

        then:
        solicitudVinculoFamiliarService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SolicitudVinculoFamiliar solicitudVinculoFamiliar = new SolicitudVinculoFamiliar()
        solicitudVinculoFamiliarService.save(solicitudVinculoFamiliar)

        then:
        solicitudVinculoFamiliar.id != null
    }
}
