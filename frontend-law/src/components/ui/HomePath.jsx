import BodyCollaborators from "./BodyCollaborators";
import BodyDeclarations from "./BodyDeclarations";
import BodyGallery from "./BodyGallery";
import BodyResults from "./BodyResults";
import BodyWelcome from "./BodyWelcome";
import { FooterWithSocialLinks } from "./FooterWithSocialLinks";
import Header from "./Header";
import InformationText from "./InformationText";

export default function HomePath() {
    return(
        <div>
            <Header />
            <BodyWelcome />
            <BodyDeclarations />
            <BodyGallery />
            <BodyResults />
            <BodyCollaborators />
            <InformationText />
            <FooterWithSocialLinks />
        </div>
    )
}