import React from 'react';
import './App.css';
import { library } from "@fortawesome/fontawesome-svg-core";
import { faUser, faUserPlus, faList } from "@fortawesome/free-solid-svg-icons";
import { RouterHome } from './components/RouterHome';

library.add(faUser, faUserPlus, faList);

function App() {
  return (
    <div className="App">
      <RouterHome />
    </div>
  );
}

export default App;
