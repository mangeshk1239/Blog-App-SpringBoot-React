import * as React from "react";

export default function BloggerPostElement(): JSX.Element {

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
        <>
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
        </>
    )
}