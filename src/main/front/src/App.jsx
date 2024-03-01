import BlogOverview from './pages/BlogOverview';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import BlogDetail from './pages/BlogDetail';

const router = createBrowserRouter([
    {
        path: '/',
        element: <BlogOverview />,
    },
    {
        path: '/blog/:blogId',
        element: <BlogDetail />,
    },
]);

function App() {
    return <RouterProvider router={router} />;
}

export default App;
