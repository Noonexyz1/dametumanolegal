import BodyCollaborators from "./components/ui/BodyCollaborators"
import BodyDeclarations from "./components/ui/BodyDeclarations"
import BodyGallery from "./components/ui/BodyGallery"
import BodyResults from "./components/ui/BodyResults"
import BodyWelcome from "./components/ui/BodyWelcome"
import { FooterWithSocialLinks } from "./components/ui/FooterWithSocialLinks"
import Header from "./components/ui/Header"

function App() {

  return (
    <div>
      <Header/>
      <BodyWelcome/>
      <BodyDeclarations/>
      <BodyGallery/>
      <BodyResults/>
      <BodyCollaborators/>
      <FooterWithSocialLinks/>
    </div>
  )
}

export default App
