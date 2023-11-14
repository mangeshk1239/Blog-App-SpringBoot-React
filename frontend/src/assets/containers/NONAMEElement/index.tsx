import * as React from "react";
import { useNavigate } from "react-router-dom";

export default function NONAMEElement(): JSX.Element {
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
        await fetch(`/api/blogger/${id}`);
    }
}