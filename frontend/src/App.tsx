import * as Router from "react-router-dom";
import * as Page from "./pages/pages";

export default function App(): JSX.Element {
  return (
    <Router.BrowserRouter>
      <Router.Routes>
        <Router.Route path="/" element={<Page.Login />} />
        <Router.Route path="/register" element={<Page.Register />} />
        <Router.Route path="/login" element={<Page.Login />} />
        <Router.Route path="/blog" element={<Page.Blog />} />
        <Router.Route path="/user/:id" element={<Page.NONAME />} />
      </Router.Routes>
    </Router.BrowserRouter>
  )
}