package jardin.virtual

abstract class Vinculo {
    String descripcion
    Familiar familiar
    Familia familia

    static belongsTo = [familia:Familia,familiar: Familiar]

    static constraints = {
        descripcion nullable: false
    }

    @Override
    String toString(){
         descripcion + " " + familia
    }
}
