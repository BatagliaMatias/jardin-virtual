package jardin.virtual

class WebFamiliaController {
    FamiliaService familiaService
    VinculoPermanenteService vinculoPermanenteService

    def index() {
        if(session.user == null){
            return redirect (uri:"/login")
        }
        if(!session.user.isAttached()){
            session.user.attach();
        }

        def familiar = session.user
        def misVinculos = familiar.vinculos
        def misFamilias = misVinculos.collect {it.familia}
        def otrasFamilias = familiaService.list().findAll {misFamilias.indexOf(it) == -1}
        respond model:[misVinculos: misVinculos, otrasFamilias:  otrasFamilias]
    }

    def familia(long idVinculo){
        if(session.user == null){
            return redirect (uri:"/login")
        }
        if(!session.user.isAttached()){
            session.user.attach();
        }

        def familiar = session.user
        def miVinculo = familiar.vinculos.find{it.id == idVinculo}
        miVinculo.attach()

        def miFamilia = miVinculo.familia
        miFamilia.attach()

        def vinculos = miFamilia.vinculos
        def ninos = miFamilia.ninos
        respond model:[miFamilia: miFamilia, miVinculo: miVinculo, vinculos: vinculos, ninos: ninos]
    }

    def crearFamilia(String nombre, String vinculo){
        if(session.user == null){
            return redirect (uri:"/login")
        }
        if(!session.user.isAttached()){
            session.user.attach()
        }

        def familiar = session.user
        def familia = new Familia(nombre: nombre)
        familiaService.save(familia)
        def vinculoPermanente = new VinculoPermanente(descripcion: vinculo, familia: familia, familiar: familiar)
        vinculoPermanenteService.save(vinculoPermanente)
        familiar.refresh()
        familia.refresh()
        redirect (uri:"/webFamilia/")
    }
}
