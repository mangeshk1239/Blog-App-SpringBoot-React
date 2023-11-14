import * as React from "react";
import * as MUI from '@mui/material';
import { TextareaAutosize as BaseTextareaAutosize } from '@mui/base/TextareaAutosize';
import { styled } from '@mui/system';

export default function BloggerPostElement(): JSX.Element {
    const [getTitle, setTitle] = React.useState<string>("");
    const [getDescription, setDescription] = React.useState<string>("");

    return (
        <>
            <form onSubmit={handleSubmit}>
                <TextareaAutosize maxLength={50} onChange={(e) => setTitle(e.target.value)} required placeholder="Title..." />
                <br />
                <TextareaAutosize onChange={(e) => setDescription(e.target.value)} required placeholder="Description..." />
                <br />
                <MUI.Button type="submit" size="medium" variant="contained">Post</MUI.Button>
            </form>
        </>
    )

    async function handleSubmit(e: React.FormEvent<HTMLFormElement>) {
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
}

const blue = {
    100: '#DAECFF',
    200: '#b6daff',
    400: '#3399FF',
    500: '#007FFF',
    600: '#0072E5',
    900: '#003A75',
};

const grey = {
    50: '#F3F6F9',
    100: '#E5EAF2',
    200: '#DAE2ED',
    300: '#C7D0DD',
    400: '#B0B8C4',
    500: '#9DA8B7',
    600: '#6B7A90',
    700: '#434D5B',
    800: '#303740',
    900: '#1C2025',
};

const TextareaAutosize = styled(BaseTextareaAutosize)(
    ({ theme }) => `
    width: 320px;
    font-family: IBM Plex Sans, sans-serif;
    font-size: 0.875rem;
    font-weight: 400;
    line-height: 1.5;
    padding: 8px 12px;
    border-radius: 8px;
    color: ${theme.palette.mode === 'dark' ? grey[300] : grey[900]};
    background: ${theme.palette.mode === 'dark' ? grey[900] : '#fff'};
    border: 1px solid ${theme.palette.mode === 'dark' ? grey[700] : grey[200]};
    box-shadow: 0px 2px 2px ${theme.palette.mode === 'dark' ? grey[900] : grey[50]};
  
    &:hover {
      border-color: ${blue[400]};
    }
  
    &:focus {
      border-color: ${blue[400]};
      box-shadow: 0 0 0 3px ${theme.palette.mode === 'dark' ? blue[600] : blue[200]};
    }
  
    // firefox
    &:focus-visible {
      outline: 0;
    }
  `,
);