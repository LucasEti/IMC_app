export function AfficherResultat({ resultat }) {
  return (
    <div>
      {resultat && (
        <div>
          <strong>IMC :</strong> {resultat.imc} <br />
          <strong>Catégorie :</strong> {resultat.categorie}
        </div>
      )}
    </div>
  );
}
export default AfficherResultat;

export function AfficherHistorique({ historique }) {
  return (
    <div>
      <h3>Historique des calculs</h3>
      {historique.length === 0 ? (
        <p>Aucun calcul enregistré.</p>
      ) : (
        <ul>
          {historique.map((item, index) => (
            <li key={index}>
              {item.date} — IMC : {item.imc} ({item.categorie})
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}

