export function Informations({ taille, poids,setPoids,setTaille }) {
    return (
        <div>
            <h2>Calculateur d'IMC</h2>

            <label>
                Poids (kg) :
                <br />
                <input
                    type="number"
                    value={poids}
                    onChange={(e) => setPoids(e.target.value)}
                    placeholder="Ex: 70"
                />
            </label>
        <br />
        <br />
            <label>
                Taille (m) :
        <br />
                <input
                    type="number"
                    step="0.01"
                    value={taille}
                    onChange={(e) => setTaille(e.target.value)}
                    placeholder="Ex: 1.75"
                />
            </label>
        <br />
        <br />
      </div>
    );
}
export default Informations;