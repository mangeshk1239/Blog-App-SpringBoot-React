import * as React from "react";
import * as MUI from '@mui/material';
import { IBlog } from "./interfaces";

export default function BlogElement(): JSX.Element {
    React.useEffect(() => {
        handleFetchBlogs();
    }, []);

    const [getBlogs, setBlogs] = React.useState<Array<IBlog>>([]);

    return (
        <>
            {
                getBlogs.length > 0 ?
                    getBlogs.map((blog) => {
                        return <MUI.Card sx={{ maxWidth: 345 }}>
                            <MUI.CardMedia
                                component="img"
                                alt="green iguana"
                                height="140"
                                image="/static/images/cards/contemplative-reptile.jpg"
                            />
                            <MUI.CardContent>
                                <MUI.Typography gutterBottom variant="h5" component="div">
                                    {blog.title}
                                </MUI.Typography>
                                <MUI.Typography variant="body2" color="text.secondary">
                                    {blog.description}
                                </MUI.Typography>
                            </MUI.CardContent>
                            <MUI.CardActions>
                                <MUI.Button size="small">Read More</MUI.Button>
                            </MUI.CardActions>
                        </MUI.Card>
                    }) :
                    <>NO BLOGS...</>
            }
        </>
    )

    async function handleFetchBlogs() {
        try {
            const response = await fetch("/api/blogs/fetch").then(response => response.json());
            if (response.success) setBlogs(response.data);
        } catch (error) {
            console.log("ERROR", error);
        }
    }
}