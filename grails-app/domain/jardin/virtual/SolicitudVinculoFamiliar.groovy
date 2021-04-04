package jardin.virtual


class SolicitudVinculoFamiliar {
    Familia familia
    Familiar familiar
    Estado estado
    Date fecha
    String vinculo

    static belongsTo = [familia:Familia,familiar: Familiar]
}
