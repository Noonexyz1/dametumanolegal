import BodyCollaborators from "./components/ui/BodyCollaborators"
import BodyDeclarations from "./components/ui/BodyDeclarations"
import BodyGallery from "./components/ui/BodyGallery"
import BodyResults from "./components/ui/BodyResults"
import BodyWelcome from "./components/ui/BodyWelcome"
import Dashboard from "./components/ui/Dashboard"
import { FooterWithSocialLinks } from "./components/ui/FooterWithSocialLinks"
import Header from "./components/ui/Header"
import InformationText from "./components/ui/InformationText"
import Login from "./components/ui/Login"

function App() {

  return (
    <div className="flex flex-col">
      <Header/>
      <BodyWelcome/>
      <BodyDeclarations/>
      <BodyGallery/>
      <BodyResults/>
      <BodyCollaborators/>
      <InformationText/>
      <FooterWithSocialLinks/>
      <Login/>
      <Dashboard/>
    </div>
  )
}

export default App
