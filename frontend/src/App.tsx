import * as Router from "react-router-dom";
import * as Page from "./pages/pages";

export default function App(): JSX.Element {
  return (
    <Router.BrowserRouter>
      <Router.Routes>
        <Router.Route path="/" element={<Page.Blog />} />
        <Router.Route path="/register" element={<Page.Register />} />
        <Router.Route path="/login" element={<Page.Login />} />
        <Router.Route path="/blogger/:id" element={<Page.Blogger />} />
        <Router.Route path="/blogger/:id/create" element={<Page.BloggerPost />} />
      </Router.Routes>
    </Router.BrowserRouter>
  )
}