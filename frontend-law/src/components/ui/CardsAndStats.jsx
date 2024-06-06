import React from "react";
import InfoCardsGroup from "./InfoCardsGroup";
import GrafStatGroup from "./GrafStatGroup";

export default function CardsAndStats(){
  return (
    <div>
      {/* Your content */}
      {/*Contenedor para mis etiquetas */}
      <InfoCardsGroup />
      {/*Contenedor para mis graficos estadisticos */}
      <GrafStatGroup />
    </div>
  );
};

