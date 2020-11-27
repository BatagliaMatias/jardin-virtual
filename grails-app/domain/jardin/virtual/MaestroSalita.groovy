package jardin.virtual

class MaestroSalita {
    Maestro maestro
    Salita salita
    static belongsTo = [maestro:Maestro,salita:Salita]

    static constraints = {
    }
}
