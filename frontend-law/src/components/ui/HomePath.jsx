import BodyCollaborators from "./BodyCollaborators";
import BodyDeclarations from "./BodyDeclarations";
import BodyGallery from "./BodyGallery";
import BodyResults from "./BodyResults";
import BodyWelcome from "./BodyWelcome";
import InformationText from "./InformationText";

export default function HomePath() {
    return(
        <div>
            <BodyWelcome />
            <BodyDeclarations />
            <BodyGallery />
            <BodyResults />
            <BodyCollaborators />
            <InformationText />
        </div>
    )
}