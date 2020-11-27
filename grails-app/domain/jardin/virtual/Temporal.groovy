package jardin.virtual

class Temporal extends Vinculo{
    Date desde
    Date hasta
    static constraints = {
        desde nullable: false
        hasta nullable: false
    }
}
