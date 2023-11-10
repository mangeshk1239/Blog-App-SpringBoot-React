import * as Router from "react-router-dom";
import * as Page from "./pages/pages";
import * as React from "react";

export default function App(): JSX.Element {
  const [getTitle, setTitle] = React.useState("");
  const [getDescription, setDescription] = React.useState("");

  const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    const id = window.location.pathname.split("/");
    await fetch(`/api/blogger/${id[2]}/create`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({ title: getTitle, description: getDescription })
    });
  }
  return (
    <Router.BrowserRouter>
      <Router.Routes>
        <Router.Route path="/" element={<Page.Login />} />
        <Router.Route path="/register" element={<Page.Register />} />
        <Router.Route path="/login" element={<Page.Login />} />
        <Router.Route path="/blog" element={<Page.Blog />} />
        <Router.Route path="/blogger/:id" element={<Page.NONAME />} />
        <Router.Route path="/blogger/:id/create" element={<>
          <form onSubmit={handleSubmit}>
            <p>Heading</p>
            <input onChange={(e) => setTitle(e.target.value)} />
            <br />
            <p>Description</p>
            <input onChange={(e) => setDescription(e.target.value)} />
            <br />
            <br />
            <button type="submit">Submit</button>
          </form>
        </>} />
      </Router.Routes>
    </Router.BrowserRouter>
  )
}