import { FooterWithSocialLinks } from "./FooterWithSocialLinks";
import Header from "./Header";
import Login from "./Login";

export default function LoginPath() {
    return(
        <div>
            <Header />
            <Login />
            <FooterWithSocialLinks />
        </div>
    )
}