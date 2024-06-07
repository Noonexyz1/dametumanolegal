import { BrowserRouter, Route, Routes } from "react-router-dom";
import HomePath from "./components/ui/HomePath";
import LoginPath from "./components/ui/LoginPath";
import Header from "./components/ui/Header";
import { FooterWithSocialLinks } from "./components/ui/FooterWithSocialLinks";
import DashboardPath from "./components/ui/DashboardPath";

function MainLayout() {
  return (
    <>
      <Header />
      <Routes>
        <Route path="/" element={<HomePath />} />
        <Route path="/login" element={<LoginPath />} />
      </Routes>
      <FooterWithSocialLinks />
    </>
  );
}

function App() {
  return (
    <div className="flex flex-col">
      <BrowserRouter>
        <Routes>
          <Route path="/*" element={<MainLayout />} />
          <Route path="/dash/*" element={<DashboardPath />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
