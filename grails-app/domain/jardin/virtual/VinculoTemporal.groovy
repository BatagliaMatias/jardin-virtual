package jardin.virtual

class VinculoTemporal extends Vinculo{
    Date desde
    Date hasta
    static constraints = {
        desde nullable: false
        hasta nullable: false
    }

    @Override
    String toString(){
        descripcion + " " + familia  + " hasta " + hasta
    }
}
