import * as Router from "react-router-dom";

export default function App(): JSX.Element {
  return (
    <Router.BrowserRouter>
      <Router.Routes>
        {/* <Router.Route path="/" element={<Home />} /> */}
        {/* <Router.Route path="users/:id" element={<Users />} /> */}
      </Router.Routes>
    </Router.BrowserRouter>
  )
}