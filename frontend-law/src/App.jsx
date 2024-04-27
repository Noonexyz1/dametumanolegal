import { BrowserRouter, Route, Routes } from "react-router-dom"
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
      <BrowserRouter>
        <Routes>
          <Route path="/" element={
            <>
              <Header />
              <BodyWelcome />
              <BodyDeclarations />
              <BodyGallery />
              <BodyResults />
              <BodyCollaborators />
              <InformationText />
              <FooterWithSocialLinks />
            </>
          } />
          <Route path="/login" element={
            <>
              <Header />
              <Login />
              <FooterWithSocialLinks />
            </>
          } />
          <Route path="/dash" element={<Dashboard />} />
        </Routes>

      </BrowserRouter>
    </div>
  )
}

export default App
