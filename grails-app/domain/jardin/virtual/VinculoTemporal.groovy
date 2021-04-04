package jardin.virtual

import java.time.ZonedDateTime

class VinculoTemporal extends Vinculo{
    ZonedDateTime desde
    ZonedDateTime hasta
    static constraints = {
        desde nullable: false
        hasta nullable: false
    }

    @Override
    String toString(){
        descripcion + " " + familia  + " hasta " + hasta
    }
}
