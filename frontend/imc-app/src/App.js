// src/App.js

import React, { useState } from 'react';
import { useEffect } from 'react';
import Informations from './Informations';
import AfficherResultat, { AfficherHistorique } from './AfficherResultat';
import { fetchDelete } from './api/imcService';
import { fetchHistorique } from './api/imcService';
import { fetchPost } from './api/imcService';

function App() {
  const [taille, setTaille] = useState('');
  const [poids, setPoids] = useState('');
  const [resultat, setResultat] = useState(null);
  const [erreur, setErreur] = useState(null);
  const [historique, setHistorique] = useState([]);

  useEffect(() => {
  fetchHistorique()
    .then(data => setHistorique(data))
    .catch(err => console.error(err));
}, []);

  return (
    <div style={{ maxWidth: 400, margin: 'auto', padding: 20, fontFamily: 'Arial' }}>
      
      <Informations
        taille={taille}
        poids={poids}
        setPoids={setPoids}
        setTaille={setTaille}
      />

      <button onClick={() => fetchPost(poids, taille, setResultat, setErreur, setHistorique)}>Calculer</button>
      <br />
      <br />
      {erreur && <div style={{ color: 'red' }}>{erreur}</div>}

      <AfficherResultat resultat={resultat} />
      <AfficherHistorique historique={historique} />
      
      <button onClick={() => fetchDelete(null,setHistorique)}>Supprimer tout l'historique</button>
      <button onClick={() => fetchDelete(historique[historique.length - 1].id,setHistorique)}>Supprimer le plus ancien</button>
    </div>
  );
}
export default App;


