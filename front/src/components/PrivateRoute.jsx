import { useAuth } from "@/context/AuthContext";
import React from "react";
import { Navigate, useLocation } from "react-router-dom";

const PrivateRoute = ({ children }) => {
  const { token } = useAuth();
  const location = useLocation();
  if (!token) {
    return (
      <Navigate
        to="/login"
        replace={true}
        state={{ return_url: location.pathname + location.search }}
      />
    );
  }
  return children;
};

export default PrivateRoute;
