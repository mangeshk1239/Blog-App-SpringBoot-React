import * as React from "react";
import { useNavigate } from "react-router-dom";

export default function BloggerElement(): JSX.Element {
    const navigate = useNavigate();

    React.useEffect(() => {
        idk(Number(window.location.pathname.split("/blogger/")[1]));
    }, []);
    return (
        <>
            <button onClick={() => navigate("/blogger/1/create")}>Create Blog</button>
        </>
    )
    async function idk(id: number): Promise<void> {
        const response = await fetch(`/api/blogger/${id}`).then(response => response.json());
        console.log("response", response);
    }
}