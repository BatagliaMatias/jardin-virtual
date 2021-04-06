package jardin.virtual

import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class VinculoTemporal extends Vinculo{
    ZonedDateTime desde
    ZonedDateTime hasta
    static constraints = {
        desde nullable: false
        hasta nullable: false
    }

    String mostrarHasta(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm")
        hasta.format(formatter)
    }

    boolean esActivo(){
        ZonedDateTime ahora = ZonedDateTime.now(ZoneId.of("America/Argentina/Buenos_Aires"))
        hasta <=> ahora == 1
    }

    @Override
    String toString(){
        descripcion + " " + familia  + " hasta " + hasta
    }

    def extender(long dias) {
        if(!esActivo()){
            //se usan setters para que el hibernate se de cuenta
            setDesde(ZonedDateTime.now(ZoneId.of("America/Argentina/Buenos_Aires")))
            setHasta(ZonedDateTime.now(ZoneId.of("America/Argentina/Buenos_Aires")))
        }
        setHasta(hasta.plusDays(dias))
        return this
    }
}
