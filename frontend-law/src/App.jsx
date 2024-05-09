import { BrowserRouter, Route, Routes } from "react-router-dom"
import HomePath from "./components/ui/HomePath"
import LoginPath from "./components/ui/LoginPath"
import DashboardPath from "./components/ui/DashboardPath"

function App() {

  return (
    <div className="flex flex-col">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<HomePath />} />
          <Route path="/login" element={<LoginPath />} />
          <Route path="/dash" element={<DashboardPath />} />
        </Routes>
      </BrowserRouter>
    </div>
  )
}

export default App
