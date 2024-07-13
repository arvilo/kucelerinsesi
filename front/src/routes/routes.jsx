import PrivateRoute from "@/components/PrivateRoute";
import AuthLayout from "@/layouts/authLayout/AuthLayout";
import HomeLayout from "@/layouts/homeLayout/HomeLayout";
import Login from "@/pages/auth/login/Login";
import Register from "@/pages/auth/register/Register";
import Contact from "@/pages/contact/Contact";
import FavoritesPets from "@/pages/favoritesPets/FavoritesPets";
import Home from "@/pages/home/Home";
import NotFound from "@/pages/notFound/NotFound";
import Profile from "@/pages/profile/Profile";

const routes = [
    {
        path: "/",
        element: <HomeLayout />,
        children: [
            {
                index: true,
                element: <Home />,
            },
            {
                path: "contact",
                element: <Contact />,
            },
            {
                path: "profile",
                auth: true,
                element: <Profile />,
            },
            {
                path: "favoritespets",
                auth: true,
                element: <FavoritesPets />,
            },
        ],
    },
    {
        path: "/login",
        element: <AuthLayout />,
        children: [
            {
                index: true,
                element: <Login />,
            },
        ],
    },
    {
        path: "/register",
        element: <AuthLayout />,
        children: [
            {
                index: true,
                element: <Register />,
            },
        ],
    },
    {
        path: "*",
        element: <NotFound />,
    },
];

const authMap = (routes) =>
    routes.map((route) => {
        if (route?.auth) {
            route.element = <PrivateRoute>{route.element}</PrivateRoute>;
        }
        if (route?.children) {
            route.children = authMap(route.children);
        }
        return route;
    });

export default authMap(routes);
